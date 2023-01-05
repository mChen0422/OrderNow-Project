import { Button, Card, Divider, List, message, Select, Tooltip,Comment } from "antd";

import React from "react";
import '../index.css'
import AddToCartButton from "./AddToCartButton";



class FoodListCard extends React.Component
{   
    
        state = {
        activeTabKey1: "tab1",
        comments: [],
        res:this.props.curRest,
}
    
    onTab1Change = (key) => {
        
        this.setState({
            activeTabKey1: key,
          });
        };
    
    
    contentList = {
        tab1:  <div>
        <img
        src={this.props.imageUrl}
        alt={this.props.name}
        style={{ height: 340, width: "100%", display: "block" }}
        />
        </div>,
        tab2: <div  style={{height:340}}>
        <List
        className="comment-list"

        itemLayout="horizontal"
        dataSource={this.state.comments}
        renderItem={(item) => (
        <li>
            <Comment
            author={item.custormerName}
            content={item.yourComment}
            />
        </li>
)}
/>
        </div>
      };
    

    render = ()=>
    {   
        return(
        <Card
        style = {{width:'100%'}}
        title={this.props.name + "  Price: "+ this.props.price}
        extra={<AddToCartButton itemId = {this.props.id}/>}
        tabList = {[
        {
            key: 'tab1',
            tab: 'Pcs',
        },
        {
            key: 'tab2',
            tab: 'Comments',
        },
        
      

        ]}
        activeTabKey={this.state.activeTabKey1}
        onTabChange={key => {
        this.onTab1Change(key);
        }}
    >

    {this.contentList[this.state.activeTabKey1]}
    </Card>
        );
    }
}

export default FoodListCard;



