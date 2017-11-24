package com.kyrostechnologies.crm.application.pipeline;

import com.kyrostechnologies.crm.model.PipeLineModel;
import com.kyrostechnologies.crm.response.PipeLineResponse;

public interface PipeLineInterface {
    PipeLineResponse getPipeLine(int UserProfileId);
    PipeLineResponse insertPipeLine(PipeLineModel model);
    PipeLineResponse updatePipeLine(PipeLineModel model);
    PipeLineResponse deletePipeLine(PipeLineModel model);
}
