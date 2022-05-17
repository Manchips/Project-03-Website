package com.example.project03website.backend;

import org.springframework.data.repository.CrudRepository;

public interface UserSheetsRepository extends CrudRepository<UserSheets,Integer> {
    UserSheets findDistinctByUserSheetsId(Integer userSheetsId);

    Iterable<UserSheets> findUserSheetsByUserSheetsId(Integer userSheetsId);
}
