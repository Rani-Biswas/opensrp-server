package org.ei.drishti.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.motechproject.util.DateUtil;

import static org.ei.drishti.service.MCTSSMSService.MCTSServiceCode;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class MCTSSMSServiceTest {
    @Mock
    DrishtiSMSService smsService;
    private MCTSSMSService mctsSMSService;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        mctsSMSService = new MCTSSMSService(smsService, "9986048731");
    }

    @Test
    public void shouldSendSMSBasedOnCodeForANC1() {
        mctsSMSService.send(MCTSServiceCode.ANC_1, "1234567", DateUtil.newDate(2012, 3, 21));

        verify(smsService).sendSMS("9986048731", "ANMPW 1234567 ANC1 210312");
    }

    @Test
    public void shouldSendSMSWithZeroPaddedDateWhenDateIsBefore10th() {
        mctsSMSService.send(MCTSServiceCode.ANC_1, "1234567", DateUtil.newDate(2012, 3, 8));

        verify(smsService).sendSMS("9986048731", "ANMPW 1234567 ANC1 080312");
    }
}