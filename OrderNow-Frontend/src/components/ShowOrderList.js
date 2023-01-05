import { Button, Drawer, List, message, Typography } from "antd";
import { useEffect, useState } from "react";
import { checkout, getCart, getOrderHistory } from "../utils";
import CreatePostButton from "./CreatePostButton.js";


const ShowOrderList = (props) => {
  const [cartVisible, setCartVisible] = useState(false);
  const [cartData, setCartData] = useState();
  const [loading, setLoading] = useState(false);
  const user = props.userInfo;

  useEffect(() => {
    if (!cartVisible) {
      return;
    }
    setLoading(true);
    getOrderHistory()
      .then((data) => {
        setCartData(data);
      })
      .catch((err) => {
        message.error(err.message);
      })
      .finally(() => {
        setLoading(false);
      });
  }, [cartVisible]);


  const onCloseDrawer = () => {
    setCartVisible(false);
  };

  const onOpenDrawer = () => {
    setCartVisible(true);
    const a = cartData;
    console.log({a});
    console.log(this,props.userInfo)
  };


  return (
    <>
      
      <Button type="primary" shape="round" onClick={onOpenDrawer}>
        OrderHistory
      </Button>
      
      <Drawer
        title="My Order History"
        onClose={onCloseDrawer}
        visible={cartVisible}
        width={520}
        footer={
          <div
            style={{
              display: "flex",
              justifyContent: "space-between",
            }}
          >
            <div> 
              <Button onClick={onCloseDrawer} style={{ marginRight: 8 }}>
                Cancel
              </Button>
              
            </div>
          </div>
        }
      >
       {cartData &&<List
          loading={loading}
          itemLayout="horizontal"
          dataSource={cartData}
          renderItem={(item) => (
            <List.Item>
              <List.Item.Meta
                title={item.menuItemName}
              />
             
              <CreatePostButton username = {user} menuname = {item.menuItemName} menuitemId = {item.menuitemId} cartId = {item.cartId}/>
              
            </List.Item>
          )}
        />}
      </Drawer>
    </>
  );
};

export default ShowOrderList;


