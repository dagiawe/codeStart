package splay;

public class extra splay {

	public static Node rightRotate(Node x)

	{

		Node y = x.left;

	    x.left = y.right;

	    y.right = x;

	    return y;

	}

	

	public static Node leftRotate(Node x)

	{

		Node y = x.right;

	    x.right = y.left;

	    y.left = x;

	    return y;

	}



	public static Node splay(Node root, int key)

{

    

    if (root == null || root.element == key)

        return root;

    

    if (root.element > key)

    {

      
        if (root.left == null) return root;

    
        if (root.left.element > key)

        {

         

            root.left.left = splay(root.left.left, key);

          
            root = rightRotate(root);

        }

        else if (root.left.element < key) 

        {

           

            root.left.right = splay(root.left.right, key);

            

            if (root.left.right != null)

                root.left = leftRotate(root.left);

        }

       

        return (root.left == null) ?

                              root : rightRotate(root);

    }

    else 

    {

        

        if (root.right == null) return root;

        

        if (root.right.element > key)

        {

            

            root.right.left = splay(root.right.left, key);

            

            if (root.right.left != null)

                root.right = rightRotate(root.right);

        }

        else if (root.right.element < key)

        {

          

            root.right.right = splay(root.right.right, key);

            root = leftRotate(root);

        }

   

        return (root.right == null) ?

                               root : leftRotate(root);

    }
}
}
