package org.auth.service.imp;

import org.auth.dao.FunctionDao;
import org.auth.entity.Function;
import org.auth.service.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("functionService")
public class FunctionServiceImpl implements FunctionService {
    @Autowired
    private FunctionDao functionDao;

    public int save(Function function) {
        return functionDao.save(function);
    }

    public int updateUrl(Integer id, String url) {
        return functionDao.updateUrl(id,url);
    }

    public int deleteFunctionById(Integer id) {
        return functionDao.deleteFunctionById(id);
    }

    public Function findFunctionById(Integer id) {
        return functionDao.findFunctionById(id);
    }

    public List<Function> findFunctions(List<Integer> ids) {
        return functionDao.findFunctions(ids);
    }

    public List<Function> findAllFunctions() {
        return functionDao.findAllFunctions();
    }

    public List<Function> findSubFunctions(Integer parentId) {
        return functionDao.findSubFunctions(parentId);
    }
}
