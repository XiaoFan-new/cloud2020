import cn.hutool.core.util.RandomUtil;
import org.junit.jupiter.api.Test;

/**
 * Create by fan
 * on 2020/5/19 11:42
 */
public class Test001 {
    @Test
    public void getjj(){
        for (int i = 0; i < 3; i++) {
            String s = RandomUtil.randomString(20);
            System.out.println(s);
        }

    }
}

