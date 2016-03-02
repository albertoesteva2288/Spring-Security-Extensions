/*
 * Copyright 2004, 2005, 2006 Acegi Technology Pty Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package org.springframework.security.core.userdetails.memory;

import java.util.*;

import org.springframework.security.core.userdetails.*;
import org.springframework.util.Assert;

/**
 * Used by {@link InMemoryDaoImpl} to store a list of users and their corresponding granted
 * authorities.
 *
 * @author Ben Alex
 */
public class UserMap {
    // ~ Static fields/initializers
    // =====================================================================================

    // ~ Instance fields
    // ================================================================================================

    private Map<String, UserDetails> userMap = new HashMap<String, UserDetails>();

    // ~ Methods
    // ========================================================================================================

    /**
     * Adds a user to the in-memory map.
     *
     * @param user the user to be stored
     *
     * @throws IllegalArgumentException if a null User was passed
     */
    public void addUser(final UserDetails user) throws IllegalArgumentException {
        Assert.notNull(user, "Must be a valid User");

        this.userMap.put(user.getUsername().toLowerCase(), user);
    }

    /**
     * Locates the specified user by performing a case insensitive search by username.
     *
     * @param username to find
     *
     * @return the located user
     *
     * @throws UsernameNotFoundException if the user could not be found
     */
    public UserDetails getUser(final String username) throws UsernameNotFoundException {
        final UserDetails result = this.userMap.get(username.toLowerCase());

        if (result == null) {
            throw new UsernameNotFoundException("Could not find user: " + username);
        }

        return result;
    }

    /**
     * Indicates the size of the user map.
     *
     * @return the number of users in the map
     */
    public int getUserCount() {
        return this.userMap.size();
    }

    /**
     * Set the users in this {@link UserMap}. Overrides previously added users.
     *
     * @param users {@link Map} &lt;{@link String}, {@link UserDetails}> with pairs (username,
     *            userdetails)
     * @since 1.1
     */
    public void setUsers(final Map<String, UserDetails> users) {
        this.userMap = users;
    }
}
