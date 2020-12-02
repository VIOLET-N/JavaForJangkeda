package com.neusoft.demo.repository;

import com.neusoft.demo.dataobject.Img;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImgRepository extends JpaRepository<Img, Integer> {
}
