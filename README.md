#### ThreadLocal

- 使用日期工具类，当用到SimpleDateFormat
- 全局存储用户信息(用户信息存入ThreadLocal，那么当前线程在任何地方需要时，都可以使用)
- 保证同一个线程，获取的数据库连接Connection是同一个
- 使用MDC保存日志信息

