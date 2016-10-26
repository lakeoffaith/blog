## java 调用.bat 创建文件



## explain

在stackoverflow上看到的问题

[链接](http://stackoverflow.com/questions/40249229/batch-bat-called-from-java-does-not-fully-execute/40250562#40250562)



## code



```
public class Main {
	public static void main(String[] args) {
		Process p;
		String cmd="cmd /c start f:\\hello.bat";
		try {
			  //执行命令
            p = Runtime.getRuntime().exec(cmd);
            InputStream in = p.getInputStream();
            int c;
            while ((c = in.read()) != -1) {
                    System.out.print(c);//如果你不需要看输出，这行可以注销掉
            }
            in.close();
            try {
                    p.waitFor();
            } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
            }
            System.out.println("done");
            
		} catch (IOException e) {
			System.out.println("play show error");
		}
	}
}
```



***

last update 2016-10-26