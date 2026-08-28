### Completable Future

When to use Completable Future?

    If you want to perform asynchronous non-blocking operations.By default it uses daemon threads.
    That means it exits when the main thread exits. Daemon threads do not keep the JVM alive.

    JVM will only wait for non-daemon (user-thread) threads to finish. Once the main method is finished, the JVM will exit even if there are daemon threads still running.
    When we call the main method, the jvm creates a non-daemon thread which is the main thread.