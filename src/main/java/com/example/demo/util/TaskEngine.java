/**
 * $Revision: 4005 $
 * $Date: 2006-06-16 08:58:27 -0700 (Fri, 16 Jun 2006) $
 *
 * Copyright (C) 2005-2008 Jive Software. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.demo.util;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Performs tasks using worker threads. It also allows tasks to be scheduled to be
 * run at future dates. This class mimics relevant methods in both
 * {@link ExecutorService} and {@link Timer}. Any {@link TimerTask} that's
 * scheduled to be run in the future will automatically be run using the thread
 * executor's thread pool. This means that the standard restriction that TimerTasks
 * should run quickly does not apply.
 *
 * @author Matt Tucker
 */
public class TaskEngine {

    private static TaskEngine instance = new TaskEngine();

    /**
     * Returns a task engine instance (singleton).
     *
     * @return a task engine.
     */
    public static TaskEngine getInstance() {
        return instance;
    }

    private ExecutorService executor;

    /**
     * Constructs a new task engine.
     */
    private TaskEngine() {
        executor = new ThreadPoolExecutor(Constants.COREPOOLSIZE, Constants.MAXIMUMPOOLSIZE,Constants.KEEPALIVETIME,
                TimeUnit.SECONDS, new SynchronousQueue<Runnable>(), new ThreadFactory() {
            final AtomicInteger threadNumber = new AtomicInteger(1);
        @Override
            public Thread newThread(Runnable runnable) {
                // Use our own naming scheme for the threads.
                Thread thread = new Thread(Thread.currentThread().getThreadGroup(), runnable,
                        "TaskEngine-pool-" + threadNumber.getAndIncrement(), 0);
                // Make workers daemon threads.
                thread.setDaemon(true);
                if (thread.getPriority() != Thread.NORM_PRIORITY) {
                    thread.setPriority(Thread.NORM_PRIORITY);
                }
                return thread;
            }
        });
    }

    /**
     * Submits a Runnable task for execution and returns a Future
     * representing that task.
     *
     * @param task the task to submit.
     * @return a Future representing pending completion of the task,
     *      and whose <tt>get()</tt> method will return <tt>null</tt>
     *      upon completion.
     * @throws RejectedExecutionException if task cannot be scheduled
     *      for execution.
     * @throws NullPointerException if task null.
     */
    public Future<?> submit(Runnable task) {
        return executor.submit(task);
    }


}