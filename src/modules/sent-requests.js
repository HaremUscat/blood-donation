import React from "react";
import Navbar from "../components/navbar";
import ReactPaginate from 'react-paginate';

class SentRequests extends React.Component {
    constructor(props) {
        super(props);

        this.handlePageClick = this.handlePageClick.bind(this);
    }

    componentWillMount() {
        this.loadRequests(this.state.username, function(requests) {

        });
    }

    handlePageClick(data) {
        let selectedPage = data.selected;
        let offset = selectedPage * this.props.perPage;
        let newSelection = this.props.emailAccounts.slice(offset, offset + this.props.perPage);
        this.props.actions.handlePageClick(newSelection);
    };

    redirectToAddAccount() {
        this.props.history.push('/add-email-account');
    }

    render() {
        if (this.props.loading) {
            return (
                <div className="container" style={{height: '100vh'}}>
                    <div className="row align-items-center justify-content-center" style={{height: '100vh'}}>
                        <h3>Loading...</h3>
                    </div>
                </div>
            );
        } else {
            if (this.props.currentSelection.length === 0) {
                return (
                    <NoEmails/>
                );
            } else {
                return (
                    <div>
                        <Navbar extraLinks={[
                            {text: "Contacts", reference: "/contact-list", extraClasses: ''},
                            {text: "Email Accounts", reference: "/email-accounts-list", extraClasses: 'activeOrange'}
                        ]}/>

                        {/* Add Button */}
                        <div style={{backgroundColor: '#f7f7f7'}}>
                            <div className="container small-padding" style={{paddingTop: '20px'}}>
                                <div className="row justify-content-end align-items-center">
                                    <div className="col-12 col-sm-4 col-lg-2">
                                        <BlockButton color='#ffa901' onClick={this.redirectToAddAccount}>Add
                                            Email</BlockButton>
                                    </div>
                                </div>
                            </div>
                        </div>

                        {/* Email Accounts Table */}
                        <div className="above-footer-smaller">
                            <div className="container" style={{padding: '0px 10px'}}>
                                <div className="row">
                                    <div className="col-12">
                                        <table className="email-accounts-table">
                                            <thead>
                                            <tr>
                                                <th>
                                                    <h6>
                                                        <span className="email-accounts-100px-right"/>
                                                        Full Name
                                                    </h6>
                                                </th>
                                                <th><h6>Email</h6></th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            {this.props.currentSelection.map((account, index) =>
                                                <tr key={index}>
                                                    <td>
                                                        <span className="email-accounts-100px-right"/>
                                                        {account.accountName}
                                                    </td>
                                                    <td>{account.userName}</td>
                                                </tr>
                                            )}
                                            </tbody>
                                        </table>
                                    </div>
                                </div>

                                {/* Pagination */}
                                <div className="row justify-content-end"
                                     style={{marginTop: '10px', marginBottom: '20px'}}>
                                    <ReactPaginate previousLabel={<i className="fa fa-angle-left" aria-hidden="true"/>}
                                                   nextLabel={<i className="fa fa-angle-right" aria-hidden="true"/>}
                                                   breakLabel={'...'}
                                                   breakClassName={"break-me"}
                                                   pageCount={Math.ceil(this.props.emailAccounts.length / this.props.perPage)}
                                                   onPageChange={this.handlePageClick}
                                                   containerClassName={"pagination"}
                                                   subContainerClassName={"pages pagination"}
                                                   activeClassName={"active-page"}
                                                   marginPagesDisplayed={1}
                                                   pageRangeDisplayed={2}/>
                                </div>
                            </div>
                        </div>

                        <Footer/>
                    </div>
                );
            }
        }
    }
}

export default SentRequests;