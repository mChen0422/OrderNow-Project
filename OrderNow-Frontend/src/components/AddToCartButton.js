import { Button, Card, Divider, List, message, Select, Tooltip,Comment } from "antd";
import { useEffect, useState } from "react";
import { addItemToCart,getCommentsById } from "../utils";
import { PlusOutlined } from "@ant-design/icons";
import '../index.css'



const AddToCartButton = (props) => {
    const [loading, setLoading] = useState(false);

    const AddToCart = () => {
      setLoading(true);
      addItemToCart(props.itemId)
        .then(() => message.success(`Successfully add item`))
        .catch((err) => message.error(err.message))
        .finally(() => {
          setLoading(false);
        });
    };
  
    return (
      <Tooltip title="Add to shopping cart">
        <Button
          loading={loading}
          type="primary"
          icon={<PlusOutlined />}
          onClick={AddToCart}
        />
      </Tooltip>
    );
  };

export default AddToCartButton
