## linux 连接宽带

  

打开终端，输入命令pppoeconf。

接下来会看到一系列配置信息，包括用户名、密码（宽带连接的用户名密码），配置好之后会有一些提示信息，一路选择yes即可。到此，宽带连接已经成功连上，Plugin rp-pppoe.so loaded.此信息说明连接成功。

然后重启下电脑。

下次开机时手动连接

打开终端，输入命令pon dsl-provider即可连接，可以用plog命令查看状态。

断开连接的命令是poff dsl-provider。