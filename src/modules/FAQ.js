import React from "react";
import Navbar from "../components/navbar";

class FAQ extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div>
                {/* Navbar */}
                <Navbar notLoggedIn={true} extraLinks={[
                    {text: "HOME", reference: "/home", extraClasses: ''},
                    {text: "FAQ", reference: "/faq", extraClasses: 'active-navbar-link'},
                    {text: "CONTACT", reference: "/contact", extraClasses: ''}
                ]}/>

                {/* Intro */}
                <div>
                    <div className="introFaq">
                        <div className="row align-items-center justify-content-center" style={{minHeight: '90vh'}}>
                            <h1>Donation FAQ</h1>
                    </div>
                        <div className="col-11 col-sm-10 col-md-11" style={{textAlign: 'left', padding: '0px 20px 30px'}}>
                            <br/>
                            <p>
                                <h3>Q: How does age affect my ability to donate?</h3>
                                <h4>A: There is a minimum (18 years old) and maximum (60 years old) age, if you fall in-between these criteria, you can donate.</h4>
                            </p>
                            <br/>
                            <br/>

                            <p>
                                <h3>Q: I have had cancer, can I donate?</h3>
                                <h4>A: In most cases you can donate again if you remain free of cancer five years after completing treatment. This is to protect your health by ensuring, as far as possible, that the cancer is gone and will not recur. Five years is the period most often used by doctors to define a cancer as presumed 'cured'. (HOWEVER, if you have a history of diseases such as leukemia or lymphoma, that involve blood, you can never donate again)</h4>
                            </p>

                            <br/>
                            <br/>
                            <p>
                                <h3>Q: I have had several alcoholic drinks prior to giving blood, can I donate?</h3>
                                <h4>A: No, this is because being intoxicated can affect your ability to understand and answer the donor questionnaire and declaration. It also affects your body’s ability to tolerate blood being taken.</h4>
                            </p>

                            <br/>
                            <br/>
                            <p>
                                <h3>Q: I take an antidepressant, can I donate?</h3>
                                <h4>A: Normally, yes, as long as you are feeling well and have no form of side effects from the medication.</h4>
                            </p>

                            <br/>
                            <br/>
                            <p>
                                <h3>Q: I am breastfeeding, can I donate?</h3>
                                <h4>A: For your health, following childbirth you need to wait at least nine months and until your baby is significantly weaned (that is, getting most of his/her nutrition from solids) before you donate blood.</h4>
                            </p>

                            <br/>
                            <br/>
                            <p>
                                <h3>Q: I have just had a piercing, can I donate?</h3>
                                <h4>A: It depends on the type of piercing, if you had your ear pierced, only plasma can be donated in the following 24 hours, following that time frame, there are no restrictions. In the case of any other piercing, you can only donate plasma for the following 4 months, after that, there are no restrictions.</h4>
                            </p>

                            <br/>
                            <br/>
                            <p>
                                <h3>Q: I have just gotten a tattoo, can I donate?</h3>
                                <h4>A: It depends if the state in which you had the tattoo done regulates tattoo facilities. If that is the case, then yes, you can donate blood, otherwise it would be advisable to wait up to 12 months prior to donating blood.</h4>
                            </p>

                            <br/>
                            <br/>
                            <p>
                                <h3>Q: I have just had acupuncture, can I donate?</h3>
                                <h4>A: Yes, if the acupuncture was performed by a registered acupuncturist or a medical practitioner, you can only donate plasma in the first 24 hours after treatment. Following that, there are no restrictions. If the practitioner was not registered, you need to confirm whether the needles were sterile, single-use ones. If not, you can only donate 4 months after the acupuncture procedure. </h4>
                            </p>


                            <br/>
                            <br/>
                            <p>
                                <h3>Q: I am a professional athlete, can I donate?</h3>
                                <h4>A: Yes, but our recommendation is not to donate whole blood during a competitive period/season. You can donate plasma at any time, though.</h4>
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default FAQ;