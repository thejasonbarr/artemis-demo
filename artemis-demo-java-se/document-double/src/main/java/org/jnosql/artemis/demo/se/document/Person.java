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

package org.jnosql.artemis.demo.se.document;


import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.jnosql.artemis.Column;
import org.jnosql.artemis.Entity;
import org.jnosql.artemis.Id;

import java.util.List;


@Entity
public class Person {

    @Id
    private String id;

    @Column
    private String name;

    @Column
    private List<String> phones;

    private String ignore;


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }



    public String getIgnore() {
        return ignore;
    }

    public Person() {
    }

    Person(String id, String name, List<String> phones, String ignore) {
        this.id = id;
        this.name = name;
        this.phones = phones;
        this.ignore = ignore;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("id", id)
                .append("name", name)
                .append("phones", phones)
                .append("ignore", ignore)
                .toString();
    }

    public static PersonBuilder builder() {
        return new PersonBuilder();
    }
}
