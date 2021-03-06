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

package org.jnosql.artemis.demo.se.cassandra;


import org.jnosql.artemis.cassandra.column.CassandraTemplate;
import org.jnosql.artemis.column.ColumnTemplate;
import org.jnosql.diana.api.column.Column;
import org.jnosql.diana.api.column.ColumnCondition;
import org.jnosql.diana.api.column.ColumnQuery;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import java.util.Arrays;
import java.util.Optional;

public class App {

    private static final Person PERSON = Person.builder().
            withPhones(Arrays.asList("234", "432"))
            .withName("Name")
            .withId(1)
            .withIgnore("Just Ignore").build();

    public static void main(String[] args) {

        try(SeContainer container = SeContainerInitializer.newInstance().initialize()) {
            ColumnTemplate columnTemplate =  container.select(CassandraTemplate.class).get();
            Person saved = columnTemplate.insert(PERSON);
            System.out.println("Person saved" + saved);

            ColumnQuery query = ColumnQuery.of("Person");
            query.and(ColumnCondition.eq(Column.of("id", 1L)));

            Optional<Person> person = columnTemplate.singleResult(query);
            System.out.println("Entity found: " + person);

        }
    }

    private App() {}
}
