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

package org.jnosql.artemis.demo.se.key;


import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.jnosql.artemis.key.KeyValueRepository;

import java.util.Arrays;
import java.util.Optional;

public class App {

    private static final User USER = User.builder().
            withPhones(Arrays.asList("234", "432"))
            .withUsername("username")
            .withName("Name")
            .build();

    public static void main(String[] args) {
        Weld weld = new Weld();
        try (WeldContainer weldContainer = weld.initialize()) {
            KeyValueRepository repository = weldContainer.instance().select(KeyValueRepository.class).get();
            User saved = repository.put(USER);
            System.out.println("User saved" + saved);
            Optional<User> person = repository.get("username", User.class);
            System.out.println("Entity found: " + person);

        }
    }
}