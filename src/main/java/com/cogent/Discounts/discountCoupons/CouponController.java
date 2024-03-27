package com.cogent.Discounts.discountCoupons;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/api/v1/coupons")
@RequiredArgsConstructor
public class CouponController {

  private final CouponService couponService;

  @GetMapping
  public List<Coupon> getAllCoupons() {
    return couponService.getAllCoupons();
  }

  @GetMapping("/api/v1/coupons/{id}")
  public ResponseEntity<Coupon> getCouponById(@PathVariable Long id) {
    return couponService.getCouponById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
  }

  @GetMapping("/api/v1/coupons/verify/{code}")
  public ResponseEntity<Coupon> verifyCouponByCode(@PathVariable String code) {
    System.out.println("Im geyying called at coupon microserve");

    Coupon coupon = couponService.verifyCouponByCode(code);
    return ResponseEntity.status(HttpStatus.OK).body(coupon);
  }

  @PostMapping("/api/v1/coupons")
  public ResponseEntity<Coupon> createCoupon(@RequestBody Coupon coupon) {
    return new ResponseEntity<>(couponService.createCoupon(coupon), HttpStatus.CREATED);
  }

  @PutMapping("/api/v1/coupons/{id}")
  public ResponseEntity<Coupon> updateCoupon(@PathVariable Long id, @RequestBody Coupon updatedCoupon) {
    Coupon result = couponService.updateCoupon(id, updatedCoupon);
    return result != null ? ResponseEntity.ok(result) : ResponseEntity.notFound().build();
  }

  @DeleteMapping("/api/v1/coupons/{id}")
  public ResponseEntity<Void> deleteCoupon(@PathVariable Long id) {
    couponService.deleteCoupon(id);
    return ResponseEntity.noContent().build();
  }
}