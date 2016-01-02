package testFile;

import junit.framework.TestCase;

/**
 * Created by zhang on 1/2/2016.
 */
public class TestImage extends TestCase {

    public void testDelete() throws Exception {
        String url = this.getClass().getResource("/").getPath();
        url = url.substring(1);
        
        System.out.println(url);
        System.out.println(TestImage.class.getClasses().getClass().getResource("/").getPath().substring(1,10));

        System.out.println(System.getProperty("user.dir"));
    }
}
