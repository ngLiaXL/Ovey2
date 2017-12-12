
package com.ldroid.network.executor;

import io.reactivex.Scheduler;


public interface ObserveThread {
    Scheduler getScheduler();
}
