package org.ei.drishti.service.reporting.rules;

import org.ei.drishti.util.SafeMap;
import org.springframework.stereotype.Component;

import static org.ei.drishti.common.AllConstants.VitaminAFields.VITAMIN_A_DOSE;
import static org.ei.drishti.common.AllConstants.VitaminAFields.VITAMIN_A_DOSE_1_VALUE;

@Component
public class IsVitaminA1DoseGivenRule implements IRule {

    @Override
    public boolean apply(SafeMap reportFields) {
        return VITAMIN_A_DOSE_1_VALUE.equalsIgnoreCase(reportFields.get(VITAMIN_A_DOSE));
    }
}
