package com.centercity.server.servlets;

import com.centercity.server.controller.DataController;
import com.centercity.server.entity.STOWork;

public class DataGet extends DataController {
    @Override
    public STOWork getOneWork(long id) {
        return super.getOneWork(id);
    }
}
