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
package com.apuntesdejava.jakartaee.ejb;

import com.apuntesdejava.jakartaee.ejb.model.Department;
import com.apuntesdejava.jakartaee.ejb.service.DepartmentService;
//import jakarta.ejb.Stateless;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Diego Silva (diego.silva@apuntesdejava.com)
 */
//@Stateless
@ApplicationScoped
public class DepartmentServiceImpl implements DepartmentService {

    private static final List<Department> DEPARTMENTS = new ArrayList<>();

    @Override
    public List<Department> findAll() {
        return DEPARTMENTS;
    }

    @Override
    public Department create(String id, String name) {
        var department = new Department();
        department.setId(id);
        department.setName(name);
        DEPARTMENTS.add(department);
        return department;
    }

    @Override
    public Optional<Department> findById(String id) {
        return DEPARTMENTS.stream().filter(department -> department.getId().equals(id)).findFirst();
    }

}
