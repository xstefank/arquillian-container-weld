/*
 * JBoss, Home of Professional Open Source
 * Copyright 2016, Red Hat Middleware LLC, and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.arquillian.container.weld.embedded.observers.scopeInitialization;

import java.util.concurrent.atomic.AtomicBoolean;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Destroyed;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;

public class ApplicationObserver {

    public static AtomicBoolean isAppScopeInitializationObserved = new AtomicBoolean();
    public static AtomicBoolean isAppScopeDestroyObserved = new AtomicBoolean();
    public static Object payload = null;

    public void observeAppScopeInit(@Observes @Initialized(ApplicationScoped.class) Object object) {
        this.payload = object;
        isAppScopeInitializationObserved.set(true);
    }

    public void observeAppScopeDestroy(@Observes @Destroyed(ApplicationScoped.class) Object object) {
        isAppScopeDestroyObserved.set(true);
    }

}
