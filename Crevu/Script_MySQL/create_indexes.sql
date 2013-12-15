CREATE INDEX idx_notification_user ON notification (id_user);


CREATE INDEX idx_social_account_user ON social_account(id_user);

CREATE INDEX idx_address_user ON address(id_user);






CREATE INDEX idx_text_wish_user ON text_wish(id_user,id_text);


CREATE INDEX idx_tshirt_proposal_user ON tshirt_proposal(id_user,id_text);


CREATE INDEX idx_sold_tshirt_user ON sold_tshirt(id_buyer,id_seller,id_tshirt_Proposal);


CREATE INDEX idx_ordered_tshirt_deal ON ordered_tshirt(id_order_Deal,id_sold_Tshirt);

CREATE INDEX idx_payment_deal ON payment(id_order_Deal);



CREATE INDEX idx_supplier_order_order ON supplier_order(id_order_Deal,id_warehouse);


CREATE INDEX idx_transaction_order ON transaction(id_supplier_Order,id_warehouse);

CREATE INDEX idx_revenue_user ON revenue(id_user,id_sold_Tshirt);




CREATE INDEX idx_basket_item_user ON basket_item(id_user,id_tshirt_Proposal);

