1.查询当前隔离级别：
    select @@global.tx_isolation,@@tx_isolation;
    
2.RR会产生幻读，可以通过X锁解决

两种锁：for update 
        lock in share model


不加行锁：
    1.同时写时锁等待，（一个事物写了，未提交，另一个事物写时会等待锁）只有等第一个事物提交，第二个事物才能写后再提交
    2.事物中的读只能读到事物开始时的状态数据。
    3.读取之后防止别的事务对记录更改，加X锁（可以防止幻读）

参考：
https://segmentfault.com/a/1190000016566788
https://blog.csdn.net/u010365819/article/details/84026040
https://www.cnblogs.com/zhoujinyi/p/3437475.html
https://blog.csdn.net/cug_jiang126com/article/details/50544728