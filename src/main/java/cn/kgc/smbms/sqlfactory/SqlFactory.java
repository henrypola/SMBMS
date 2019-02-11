package cn.kgc.smbms.sqlfactory;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by pc on 2019/2/11.
 */
public class SqlFactory {
    private static SqlSessionFactory factory;

    private static synchronized void init(){
        if(null == factory){
            try {
                Reader reader = Resources.getResourceAsReader("mybatis.xml");
                factory = new SqlSessionFactoryBuilder().build(reader);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static <T> SqlSessionEx<T> getSessionEx(Class<T> c){
        if(null == factory){
            init();
        }
        return new SqlSessionEx<T>() {
            private SqlSession sqlSession;

            {
                sqlSession = factory.openSession();
            }

            public T getMapper(Class<T> c) {
                return sqlSession.getMapper(c);
            }

            public void close() {
                if(null != sqlSession){
                    sqlSession.close();
                }
            }
        };
    }
}