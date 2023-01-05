
import { PostForm } from "./PostForm";
import { makecomments } from "../utils";
import React, { Component, createRef } from "react";
import { Modal, Button, message } from "antd";


class CreatePostButton extends Component
{
  state = {
    visible: false,
    confirmLoading: false
  };

  showModal = () => {
    this.setState({
      visible: true
    });
  };

  handleOk = () => {
    this.setState({
      confirmLoading: true
    });

    // get form data
    this.postForm
      .validateFields()
      .then((form) => {
        console.log(form);
        const { Comments, uploadPost } = form;
        console.log(this.props.menuname);
        const formData = {
          "cartId": this.props.cartId,
          
          "menuitemId": this.props.menuitemId,
          "menuItemName":this.props.menuname,
          "custormerName":this.props.username,
          "yourComment":Comments
          
      };
      makecomments(formData)
      .then((data) => {
        console.log(data,formData);
        message.success('Post comments successfully');
      })
      .catch((err) => {
        message.error(err.message);
      })
      .finally(() => {
        this.setState({
          confirmLoading: false,
          visible:false,
        });
      });
      }
        ).catch((err) => {
          console.log("err ir validate form -> ", err);
        });
      };


  handleCancel = () => {
    console.log("Clicked cancel button");
    this.setState({
      visible: false
    });
  };

  render() 
  {
    const { visible, confirmLoading } = this.state;
    return (
      <div>
        <Button type="primary" onClick={this.showModal}>
          Comments
        </Button>
        <Modal
          title="Create New Post"
          visible={visible}
          onOk={this.handleOk}
          okText="Create"
          confirmLoading={confirmLoading}
          onCancel={this.handleCancel}
        >
          <PostForm ref={(refInstance) => (this.postForm = refInstance)} />
        </Modal>
      </div>
    );
  }
}

export default CreatePostButton;
