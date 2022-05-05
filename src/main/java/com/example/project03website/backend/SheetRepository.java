package com.example.project03website.backend;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface SheetRepository extends CrudRepository<Sheet,Integer>{
    Sheet findDistinctBySheetId(Integer sheetId);
}
