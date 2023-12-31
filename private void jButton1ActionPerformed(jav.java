private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                       
    // TODO add your handling code here:
    //first get rollno and name enter by user
    String rollNo = txtRollNo.getText();
    String Name = txtName.getText();
   
    //convert roll no into integer
    int RNo = Integer.parseInt(rollNo);
    //connection
    try{
        //open connection
        Class.forName("com.mysql.jdbc.Driver");
       
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test0","root","0000");
        //here student_info is a database
        //root is username of mysql and mysql@123 is a password
       
        //for insert data into table
        Statement stm = con.createStatement();
        
       
        String sql = "INSERT INTO CLASS5  VALUES("+RNo+",'"+Name+"')";
        //class5 in above queary is a table
        //EXECUTE STATEMENT
        stm.executeUpdate(sql); //here insert query apply
       
        //display message of record inserted
        JOptionPane.showMessageDialog(this, "student Record Inserted");
        txtName.setText("");
        txtRollNo.setText("");
        //close connection
        con.close();
       
       
    }catch(Exception e){
        System.out.println(e.getMessage());
    }
