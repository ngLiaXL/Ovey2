
package com.ldroid.kwei.executor;

import io.reactivex.Scheduler;


public interface ObserveThread {
    Scheduler getScheduler();
}
