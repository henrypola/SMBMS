package cn.kgc.smbms.sqlfactory;

/**
 * Created by pc on 2019/2/11.
 */
public interface SqlSessionEx<T> {
    T getMapper(Class<T> c);
    void close();
}
