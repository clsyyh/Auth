package org.auth.service;

import org.auth.entity.Function;

import java.util.List;

public interface FunctionService {
    public int save(Function function);
    public int updateUrl(Integer id,String url);
    public int deleteFunctionById(Integer id);
    public Function findFunctionById(Integer id);
    public List<Function> findFunctions(List<Integer> ids);
    public List<Function> findAllFunctions();
    public List<Function> findSubFunctions(Integer parentId);
}
