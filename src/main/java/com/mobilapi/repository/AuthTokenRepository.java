package com.mobilapi.repository;

import com.mobilapi.domain.customer.AuthToken;
import org.mongodb.morphia.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class AuthTokenRepository extends GenericRepository<AuthToken> {


    public AuthTokenRepository() {
        super(AuthToken.class);
    }

    public AuthToken findAccountByTokenAndSeries(String token, String series) {

        return getDatastore().find(AuthToken.class).filter("token",token).filter("series",series).get();
    }


    public void deleteByTokenAndSeries(String token, String series) {
        Query<AuthToken> query = (Query<AuthToken>) getDatastore()
                .find(AuthToken.class).filter("token",token).filter("series",series).get();
        getDatastore().delete(query);
    }

    //@Transactional
    //@Modifying
    //@Query(nativeQuery = true, value = "delete  from auth_token where 1="
    //        + "case "
    //       + "when (last_modified_date is null and TIMESTAMPDIFF(MINUTE,created_date,sysdate()) > 2) then 1 "
    //     + "when (last_modified_date <> null and TIMESTAMPDIFF(MINUTE,last_modified_date,sysdate()) > 2) then 1 "
    //   + "else 0 " + "end ")
    public void deleteTimedoutTokens(){

    }

}
