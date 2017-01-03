## spring



* 确保在地址中的字符都为utf-8编码，否则会出现乱码

  就要在拦截chain中增加字符拦截设置，utf-8，这种强迫转换，CharacterEncodingFilter



* 在一个系统中需要每个一个时间就需要把报告信息发送到用户的邮箱中，就需要quartz，使用这个就会产生新的线程，线程会访问资源。如果是spring产生的线程，里面的对象会自动回收，如果是quartz这个框架，里面的对象就会出现问题，不能自动回收，这个时候，我们就需要添加监视器，来定时的清楚这些对象。就需要用到introspectorCleanupListener