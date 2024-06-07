package com.play.ME;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    private List<Post> postList;
    private List<Post> filteredPostList;
    private Context context;

    public PostAdapter(List<Post> postList, Context context) {
        this.postList = postList;
        this.filteredPostList = new ArrayList<>(postList); // Create a copy of the original list
        this.context = context;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        Post post = filteredPostList.get(position);
        holder.bind(post);
    }

    @Override
    public int getItemCount() {
        return filteredPostList.size();
    }

    public void filterList(List<Post> filteredList) {
        this.filteredPostList = filteredList;
        notifyDataSetChanged();
    }

    class PostViewHolder extends RecyclerView.ViewHolder {
        private TextView postTitle;
        private TextView postAuthor;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            postTitle = itemView.findViewById(R.id.post_title);
            postAuthor = itemView.findViewById(R.id.post_author);
        }

        public void bind(Post post) {
            postTitle.setText(post.getTitle());
            postAuthor.setText(post.getAuthor());
        }
    }
}
