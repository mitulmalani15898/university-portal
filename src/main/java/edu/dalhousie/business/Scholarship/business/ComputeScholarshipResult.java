package edu.dalhousie.business.Scholarship.business;

import edu.dalhousie.business.Scholarship.constants.StringConstants;

public class ComputeScholarshipResult {

    private final int eligibilityScore = 400;

    public String computeResult(float score) {
        String decision = "";

        if (score >= eligibilityScore) {
            decision = StringConstants.kEligibleForScholarship;
        } else {
            decision = StringConstants.kNotEligibleForScholarship;
        }

        return decision;
    }

}