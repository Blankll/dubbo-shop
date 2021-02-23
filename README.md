# dubbo-shop
[![YourActionName Actions Status](https://github.com/Blankll/dubbo-shop/workflows/shop-services-build/badge.svg)](https://github.com//Blankll/dubbo-shop/actions)
[![YourActionName Actions Status](https://github.com/Blankll/dubbo-shop/workflows/shop-ui-build/badge.svg)](https://github.com//Blankll/dubbo-shop/actions)

**a micro-service shop**

backend services:
- shop-gateway
- shop-common
- shop-coupon
- shop-goods
- shop-order
- shop-pay
- shop-user

font-end:
- shop-ui

## requirement
- java version 11
- docker
- docker-compose
- react-16

start backend service locally
```bash
./shop-services/scripts/start-local.sh
```
start ui locally
```bash
cd shop-ui
npm run start
```
