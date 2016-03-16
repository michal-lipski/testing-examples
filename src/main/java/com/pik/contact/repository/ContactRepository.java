
package com.pik.contact.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pik.contact.domain.Contact;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, String> {
    @Query("select c from Contact c where lower(c.id) like :keyword% "
            + "or lower(c.name) like :keyword% "
            + "or lower(c.fullName) like :keyword% "
            + "or lower(c.jobTitle) like :keyword% "
            + "or lower(c.email) like :keyword% "
            + "or lower(c.mobile) like :keyword% "
            + "or lower(c.skypeId) like :keyword% "
            + "order by c.name")
    List<Contact> searchContacts(@Param("keyword") String keyword);
    
    @Modifying
    @Query("delete from Contact where id in (:ids)")
    void deleteContact(@Param("ids") String... ids);
}