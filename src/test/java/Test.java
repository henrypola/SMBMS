import cn.kgc.smbms.mappers.ProviderMapper;
import cn.kgc.smbms.pojo.Provider;
import cn.kgc.smbms.sqlfactory.SqlFactory;
import cn.kgc.smbms.sqlfactory.SqlSessionEx;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pc on 2019/2/11.
 */
public class Test {
    public static void main(String[] args) {
        SqlSessionEx<ProviderMapper> sse = SqlFactory.getSessionEx(ProviderMapper.class);
        ProviderMapper pm = sse.getMapper(ProviderMapper.class);
        List<Provider> list = new ArrayList<Provider>();
        list.add(new Provider());
    }
}