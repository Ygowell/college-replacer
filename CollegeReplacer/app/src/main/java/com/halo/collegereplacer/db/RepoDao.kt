package com.halo.collegereplacer.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.halo.collegereplacer.model.Repo
import com.halo.collegereplacer.model.RepoSearchResponse
import io.reactivex.Observable

/**
 * Created by James on 2019/3/16.
 * Desc:
 */
@Dao
interface RepoDao {

    @Insert
    fun insert(repoList: List<Repo>)

    @Query("SELECT * FROM repos WHERE (name LIKE :queryString) OR (description LIKE " +
                ":queryString) ORDER BY stars DESC, name ASC")
    fun queryByName(queryString: String): Observable<RepoSearchResponse>
}