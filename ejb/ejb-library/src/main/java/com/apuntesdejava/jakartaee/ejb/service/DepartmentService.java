/*
 * Copyright 2024 Diego Silva (diego.silva@apuntesdejava.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.apuntesdejava.jakartaee.ejb.service;

import com.apuntesdejava.jakartaee.ejb.model.Department;
//import jakarta.ejb.Remote;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Diego Silva (diego.silva@apuntesdejava.com)
 */
//@Remote
public interface DepartmentService {

    List<Department> findAll();

    Department create(String id, String name);

    Optional<Department> findById(String id);
}
