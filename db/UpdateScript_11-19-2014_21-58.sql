ALTER TABLE `realstate`.`property_view` 
ADD COLUMN `viewDate` DATETIME NULL AFTER `propertyID`,
ADD COLUMN `comment` VARCHAR(1000) NULL AFTER `viewDate`
ADD COLUMN `clientName` VARCHAR(1000) NULL AFTER `clientID`;


