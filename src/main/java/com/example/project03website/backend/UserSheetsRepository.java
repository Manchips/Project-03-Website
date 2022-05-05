package com.example.project03website.backend;

import org.springframework.data.repository.CrudRepository;

public interface UserSheetsRepository extends CrudRepository<SavedSheets,Integer> {
    UserSheets findDistinctByUserSheetsId(Integer userSheetsId);
}
