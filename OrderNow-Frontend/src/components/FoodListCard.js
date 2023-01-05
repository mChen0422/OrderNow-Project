import { Button, Card, Divider, List, message, Select, Tooltip,Comment } from "antd";
import { useEffect, useState } from "react";
import { addItemToCart,getCommentsById } from "../utils";
import { PlusOutlined } from "@ant-design/icons";
import CommentBox from "./CommentBox";
import '../index.css';


const AddToCartButton = ({ itemId }) => {
  const [loading, setLoading] = useState(false);

  const AddToCart = () => {
    setLoading(true);
    addItemToCart(itemId)
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


const FoodListCard = (props)=>
{
    const [activeTabKey1, setActiveTabKey1] = useState('tab1');

    const onTab1Change = (key) => {
      setActiveTabKey1(key);
      console.log("hello",props.imageUrl);
      
      };
    const contentList = {
      tab1:  <div>
            <img
            src={props.imageUrl}
            alt={props.name}
            style={{ height: 340, width: "100%", display: "block" }}
            />
            </div>,
      tab2: <div  style={{height:340}}>
      <CommentBox foodid = {props.id} />
      </div>
      
    };

  return(
    <Card
        style = {{width:'100%'}}
        title={props.name + "  Price: "+ props.price}
        extra={<AddToCartButton itemId = {props.id}/>}
        tabList = {[
        {
            key: 'tab1',
            tab: 'Pcs',
        },
        {
            key: 'tab2',
            tab: 'Comments',
        }
        ]}
        activeTabKey={activeTabKey1}
        onTabChange={key => {
          onTab1Change(key);
        }}
    >

    {contentList[activeTabKey1]}
    </Card>);
};

export default FoodListCard;
