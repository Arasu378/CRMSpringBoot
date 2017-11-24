package com.kyrostechnologies.crm.application.stages.interfaceclass;

import com.kyrostechnologies.crm.model.StagesModel;
import com.kyrostechnologies.crm.response.StagesResponse;
import javafx.stage.Stage;

public interface StagesInterface {
    StagesResponse getStagesByStageId(int StageId);
    StagesResponse getStagesByPipeLineId(int PipeLineId);
    StagesResponse insertStages(StagesModel model);
    StagesResponse updateStages(StagesModel model);
    StagesResponse deleteStages(StagesModel model);

}
