package com.example.project03website.backend;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface SavedSheetRepository extends CrudRepository<SavedSheets,Integer>{
    SavedSheets findDistinctBySavedSheetId(Integer savedSheetId);
}
