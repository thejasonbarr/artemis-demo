/*
 * Copyright (c) 2017 Otávio Santana and others
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Apache License v2.0 which accompanies this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Apache License v2.0 is available at http://www.opensource.org/licenses/apache2.0.php.
 *
 * You may elect to redistribute this code under either of these licenses.
 *
 * Contributors:
 *
 * Otavio Santana
 */

package org.jnosql.diana.jsr363.producers;

import org.jnosql.diana.api.document.DocumentCollectionManager;
import org.jnosql.diana.api.document.DocumentCollectionManagerFactory;
import org.jnosql.diana.api.document.DocumentConfiguration;
import org.jnosql.diana.mongodb.document.MongoDBDocumentConfiguration;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@ApplicationScoped
class DocumentCollectionFactory {

    private DocumentCollectionManagerFactory managerFactory;

    @PostConstruct
    public void setup() {
        DocumentConfiguration configuration = new MongoDBDocumentConfiguration();
        managerFactory = configuration.get();
    }


    @Produces
    public DocumentCollectionManagerFactory getManagerFactory() {
        return managerFactory;
    }

    @Produces
    public DocumentCollectionManager getManager() {
        return managerFactory.get("jsr363-demo");
    }

}
