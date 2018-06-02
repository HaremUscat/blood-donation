package ro.ubb.donation.core.service;

import ro.ubb.donation.core.model.Result;

import java.util.Optional;

public interface ResultService {
    Optional<Result> findResult(int id);

    Optional<Result> findResultByCnp(String cnp);

    Result updateResult(int resultId, boolean illnessDiscovered, String illnessInfo, String resultPdf);

    Result createResult(boolean illnessDiscovered, String illnessInfo, String resultPdf);

    Result deleteResult(int resultId);
}
