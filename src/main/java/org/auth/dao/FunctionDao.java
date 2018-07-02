package org.auth.dao;

import org.auth.entity.Function;

import java.util.List;
import java.util.Map;

public interface FunctionDao {
    public int save(Function function);
    public int updateUrl(Integer id,String url);
    public int deleteFunctionById(Integer id);
    public Function findFunctionById(Integer id);
    public List<Function> findFunctions(List<Integer> ids);
    public List<Function> findAllFunctions();
    public List<Function> findSubFunctions(Integer parentId);
}
